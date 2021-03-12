package com.epam.javabasic.domain.playroom.client.impl;

import com.epam.javabasic.domain.playroom.bean.Toy;
import com.epam.javabasic.domain.playroom.client.IPlayroom;

import java.util.List;

/**
 * Created by anton_chyrko on 10/8/20.
 */
public class PlayroomBaseClient implements IPlayroom {

	private List<Toy> toyList;

	public PlayroomBaseClient(List<Toy> toyList) {
		this.toyList = toyList;
	}

	@Override
	public List<Toy> getAllToys() {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public List<Toy> getToysByParameter(String parameter, String value) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public boolean addToy(Toy toy) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public boolean removeToy(Toy toy) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public boolean updateToy(String id, Toy toy) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	public List<Toy> getToyList() {
		throw new UnsupportedOperationException("You need to implement this method");
	}
}
