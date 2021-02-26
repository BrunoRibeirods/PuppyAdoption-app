package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.entities.Puppy

class Repository {

    fun getAllPuppies(): List<Puppy> {
        return puppies
    }

    companion object{
        val puppies = listOf<Puppy>(
            Puppy("Marley", "Male", 10, R.drawable.dog),
            Puppy("Zeca", "Male", 3, R.drawable.dog1),
            Puppy("Lore", "Female", 5, R.drawable.dog2),
            Puppy("Dogga", "Female", 17, R.drawable.dog3),
            Puppy("Zeus", "Male", 17, R.drawable.dog5),
        )
    }
}