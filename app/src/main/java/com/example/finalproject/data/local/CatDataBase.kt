package com.example.finalproject.data.local

import com.example.finalproject.data.CatDataClass

class CatDataBase {
    companion object {
    var myAnimalsCats = ArrayList<CatDataClass>()


    fun getDataFromDB(): ArrayList<CatDataClass> {
        var catBarbos = CatDataClass(
            "Barbos",
            "Cat",
            "https://www.famousbirthdays.com/faces/lyo-the-cat-image.jpg"
        )
        var catBonya = CatDataClass(
            "Bonya",
            "Cat",
            "https://cdn.pixabay.com/photo/2015/11/16/22/14/cat-1046544__480.jpg"
        )
        var catHarley =
            CatDataClass("Harley", "Cat", "https://wallpaperaccess.com/full/2954660.jpg")

        myAnimalsCats.add(catBarbos)
        myAnimalsCats.add(catBonya)
        myAnimalsCats.add(catHarley)

        return myAnimalsCats
    }
}


}