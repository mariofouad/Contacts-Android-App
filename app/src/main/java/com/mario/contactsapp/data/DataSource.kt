package com.mario.contactsapp.data

import com.mario.contactsapp.R
import com.mario.contactsapp.data.constants.PhoneNumbers
import com.mario.contactsapp.model.Contact

class DataSource {
    fun getContactsData(): List<Contact> {
        val contacts = mutableListOf<Contact>()

        contacts.add(
            Contact(
                name = R.string.auntie,
                picture = R.drawable.auntie,
                phoneNumber = PhoneNumbers.AUNTIE
            )
        )
        contacts.add(
            Contact(
                name = R.string.brother,
                picture = R.drawable.brother,
                phoneNumber = PhoneNumbers.BROTHER
            )
        )
        contacts.add(
            Contact(
                name = R.string.daughter,
                picture = R.drawable.daughter,
                phoneNumber = PhoneNumbers.DAUGHTER
            )
        )
        contacts.add(
            Contact(
                name = R.string.friend_1,
                picture = R.drawable.friend_1,
                phoneNumber = PhoneNumbers.FRIEND1
            )
        )
        contacts.add(
            Contact(
                name = R.string.friend_2,
                picture = R.drawable.friend_2,
                phoneNumber = PhoneNumbers.FRIEND2
            )
        )
        contacts.add(
            Contact(
                name = R.string.grandfather,
                picture = R.drawable.grandfather,
                phoneNumber = PhoneNumbers.GRANDFATHER
            )
        )
        contacts.add(
            Contact(
                name = R.string.granny,
                picture = R.drawable.granny,
                phoneNumber = PhoneNumbers.GRANNY
            )
        )
        contacts.add(
            Contact(
                name = R.string.neighbour,
                picture = R.drawable.neigbour,
                phoneNumber = PhoneNumbers.NEIGHBOR
            )
        )
        contacts.add(
            Contact(
                name = R.string.sister,
                picture = R.drawable.sister,
                phoneNumber = PhoneNumbers.SISTER
            )
        )
        contacts.add(
            Contact(
                name = R.string.son,
                picture = R.drawable.son,
                phoneNumber = PhoneNumbers.SON
            )
        )
        contacts.add(
            Contact(
                name = R.string.uncle,
                picture = R.drawable.uncle,
                phoneNumber = PhoneNumbers.UNCLE
            )
        )
        return contacts
    }

//    fun getHomeData(): Contact {
//        return Contact(name = R.string.home, picture = null, phoneNumber = PhoneNumbers.HOME)
//    }
}