package com.epam.javabasic.domain.playroom.bean;

import com.epam.javabasic.domain.playroom.constants.GameType;
import com.epam.javabasic.domain.playroom.constants.Gender;
import com.epam.javabasic.domain.playroom.constants.Material;
import com.epam.javabasic.domain.playroom.constants.Size;

import java.util.Objects;

/**
 * Created by anton_chyrko on 10/9/20.
 */
public class Toy extends Domain{

	private String toyName;
	private Gender gender;
	private int age;
	private double price;
	private Material material;
	private Size size;
	private GameType gameType;

	public Toy(String toyName, GameType gameType, Gender gender, int age, Size size, Material material, double price) {
		this.toyName = toyName;
		this.gameType = gameType;
		this.gender = gender;
		this.age = age;
		this.size = size;
		this.material = material;
		this.price = price;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Toy toy = (Toy) o;
		return age == toy.age &&
				Double.compare(toy.price, price) == 0 &&
				toyName.equals(toy.toyName) &&
				gender == toy.gender &&
				material == toy.material &&
				size == toy.size &&
				gameType == toy.gameType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(toyName, gender, age, price, material, size, gameType);
	}

	@Override
	public String toString() {
		return "Toy{" +
				"toyName='" + toyName + '\'' +
				", gender=" + gender +
				", age=" + age +
				", price=" + price +
				", material=" + material +
				", size=" + size +
				", gameType=" + gameType +
				'}';
	}
}
