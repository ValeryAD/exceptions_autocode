package com.epam.javabasic.domain.playroom.client;

import com.epam.javabasic.domain.playroom.bean.Toy;

import java.util.List;

/**
 * Created by anton_chyrko on 10/8/20.
 */
public interface IPlayroom {

	List<Toy> getAllToys();

	List<Toy> getToysByParameter(String parameter, String value);

	boolean addToy(Toy toy);

	boolean removeToy(Toy toy);

	boolean updateToy(Long id, Toy toy);
}
