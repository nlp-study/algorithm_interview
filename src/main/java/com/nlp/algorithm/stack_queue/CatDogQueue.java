package com.nlp.algorithm.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return type;
	}
}

class Dog extends Pet {
	public Dog(String type) {
		super(type);
	}
}

class Cat extends Pet {
	public Cat(String type) {
		super(type);
	}
}

class CatDog {
	Pet pet;
	long count;

	public CatDog(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}
	
	public long getCount()
	{
		return count;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public void setCount(long count) {
		this.count = count;
	}
}

public  class CatDogQueue {
	Queue<CatDog> catQueue = new LinkedList<CatDog>();
	Queue<CatDog> dogQueue = new LinkedList<CatDog>();

	public void add(Pet pet) {
		int count = catQueue.size() + dogQueue.size();
		CatDog catDog = new CatDog(pet, count);
		if(pet.getPetType().startsWith("cat"))
		{
			catQueue.add(catDog);
		}
		else
		{
			dogQueue.add(catDog);
		}
	}

	public Pet pollAll() {
		
			if(catQueue.isEmpty())
			{
				return dogQueue.poll().getPet();
			}
			if(dogQueue.isEmpty())
			{
				return  catQueue.poll().getPet();
			}
			
			CatDog cat = catQueue.peek();
			CatDog dog = dogQueue.peek();
			if(cat.getCount() < dog.getCount())
			{
				return  catQueue.poll().getPet();
			}
			return  dogQueue.poll().getPet();
	}
	
	public  Pet pollDog()
	{
//		if(this.dogQueue.isEmpty())
//		{
//			throw RunTimeException("");
//		}
		return dogQueue.poll().getPet();
	}
	
	public  Pet pollCat()
	{
//		if(this.dogQueue.isEmpty())
//		{
//			throw RunTimeException("");
//		}
		return catQueue.poll().getPet();
	}
	
	public boolean isDogEmpty()
	{
		return this.dogQueue.isEmpty();
	}
	
	public boolean isCatEmpty()
	{
		return this.catQueue.isEmpty();
	}
	
	public boolean isEmpty()
	{
		return this.catQueue.isEmpty()&this.dogQueue.isEmpty();
	}
	
	public static void main(String[] args)
	{
		CatDogQueue catDogQueue = new CatDogQueue();
		
		catDogQueue.add(new Cat("cat1"));
		catDogQueue.add(new Cat("cat2"));
		catDogQueue.add(new Cat("dog1"));
		catDogQueue.add(new Cat("dog2"));
		catDogQueue.add(new Cat("dog3"));
		catDogQueue.add(new Cat("cat3"));
		catDogQueue.add(new Cat("cat4"));
		
		System.out.println("isCatEmpty:"+catDogQueue.isCatEmpty());
		System.out.println("isDogEmpty:"+catDogQueue.isDogEmpty());
//		while(!catDogQueue.isEmpty())
//		{
//			System.out.println(catDogQueue.pollAll().getPetType());
//		}
		
		while(!catDogQueue.isDogEmpty())
		{
			System.out.println(catDogQueue.pollDog().getPetType());
		}
		
		while(!catDogQueue.isCatEmpty())
		{
			System.out.println(catDogQueue.pollCat().getPetType());
		}
	}
	
}
