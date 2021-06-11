package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.constants.*;
import com.epam.tat.exceptions.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayroomBaseClient implements IPlayroom {

    private List<Toy> toyList;

    public PlayroomBaseClient(List<Toy> toyList) {
        this.toyList = toyList;
    }

    @Override
    public List<Toy> getAllToys() {
        if (toyList == null) {
            throw new InitializationException();
        }
        return toyList;
    }

    @Override
    public List<Toy> getToysByParameter(String parameter, String value) {
        if (toyList == null) {
            throw new InitializationException();
        }

        if (parameter == null || value == null) {
            throw new GetToysByParameterException();
        }

        Parameter checkedParameter;
        try {
            checkedParameter = Parameter.valueOf(parameter.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new GetToysByParameterException();
        }

        List<Toy> toysFilteredByParameter = new ArrayList<>();
        for (Toy toy : toyList) {
            if (isToyFitsByParameter(toy, checkedParameter, value.toUpperCase())) {
                toysFilteredByParameter.add(toy);
            }
        }
        return toysFilteredByParameter;
    }

    private boolean isToyFitsByParameter(Toy toy, Parameter parameter, String value) {
        switch (parameter) {
            case ID:
                if (toy.getId() == Long.valueOf(value)) {
                    return true;
                }
                break;
            case TOY_NAME:
                if (toy.getToyName().toUpperCase().equals(value)) {
                    return true;
                }
                break;
            case GENDER:
                if (toy.getGender() == Gender.valueOf(value)) {
                    return true;
                }
            case AGE:
                if (toy.getAge() == Integer.parseInt(value)) {
                    return true;
                }
                break;
            case PRICE:
                if (toy.getPrice() == Double.valueOf(value)) {
                    return true;
                }
                break;
            case MATERIAL:
                if (toy.getMaterial() == Material.valueOf(value)) {
                    return true;
                }
                break;
            case SIZE:
                if (toy.getSize() == Size.valueOf(value)) {
                    return true;
                }
            case GAME_TYPE:
                if (toy.getGameType() == GameType.valueOf(value)) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public boolean addToy(Toy toy) {
        if (toyList == null) {
            throw new InitializationException();
        }

        if (toy == null || toyList.stream().anyMatch((tempToy) -> tempToy.getId() == toy.getId())) {
            throw new AddToyException();
        }

        return toyList.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        if (toyList == null) {
            throw new InitializationException();
        }

        if (toy == null) {
            throw new RemoveToyException();
        }

        return toyList.remove(toy);
    }

    @Override
    public boolean updateToy(Long id, Toy toy) {

        if (toyList == null) {
            throw new InitializationException();
        }

        Optional<Toy> optional = toyList.stream().filter(tempToy -> tempToy.getId().equals(id)).findFirst();

        if (optional.isEmpty() || toy == null) {
            throw new UpdateToyException();
        }

        toy.setId(id);
        toyList.set(toyList.indexOf(optional.get()), toy);

        return true;
    }

    public List<Toy> getToyList() {
        if (toyList == null) {
            throw new InitializationException();
        }
        return toyList;
    }
}
