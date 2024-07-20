package com.mario.contactsapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mario.contactsapp.data.DataSource
import com.mario.contactsapp.data.constants.PhoneNumbers
import com.mario.contactsapp.model.Contact
import com.mario.contactsapp.ui.theme.ContactsAppTheme
import com.mario.contactsapp.ui.theme.Gray

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                val context = LocalContext.current
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Contacts App", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                            },
                            actions = {
                                IconButton(onClick = {
                                    navigateToDial(
                                        PhoneNumbers.HOME,
                                        context = context
                                    )
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Home,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            },
                        )
                    },
                ) { innerPadding ->
                    ContactsList(
                        contacts = DataSource().getContactsData(),
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun ContactsList(contacts: List<Contact>, modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(contacts) { contact ->
            ContactListItem(contact = contact)
        }
    }
}

@Composable
fun ContactListItem(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        colors = CardDefaults.cardColors(containerColor = Gray),
        modifier = modifier.clickable { navigateToDial(contact.phoneNumber, context) }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = contact.picture),
                contentDescription = stringResource(
                    id = contact.name
                ),
            )
            Text(
                text = stringResource(id = contact.name),
                fontWeight = FontWeight.W500,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            SelectionContainer {
                Text(
                    text = contact.phoneNumber,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}


fun navigateToDial(phoneNumber: String, context: Context) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun ContactListItemPreview(modifier: Modifier = Modifier) {
    ContactListItem(Contact(R.string.son, R.drawable.son, PhoneNumbers.SON))
}