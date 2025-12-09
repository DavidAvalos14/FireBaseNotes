package com.example.firebasenotes.views.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.firebasenotes.components.CardNote
import com.example.firebasenotes.viewModels.NotesViewModel
import com.example.firebasenotes.ui.theme.Amarillo2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, notesVM: NotesViewModel){

    LaunchedEffect(Unit){
        notesVM.fetchNotes()
    }

    val datos by notesVM.notesData.collectAsState()

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        // Caja que simula 3 columnas: izquierda - centro - derecha
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Mis Notas",
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            notesVM.signOut()
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = ""
                            )
                        }
                    },
                    actions = {
                        // Agregamos un espacio invisible del mismo tamaño que el icono
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = null,
                            modifier = Modifier.alpha(0f)  // invisible pero ocupa espacio
                        )
                    }
                )


                // Línea debajo del título
                androidx.compose.material3.Divider()
            }
        },

        floatingActionButton = {
            androidx.compose.material3.FloatingActionButton(
                onClick = { navController.navigate("AddNoteView") },
                containerColor = Amarillo2,      // tu color amarillo
                contentColor = Color.White       // icono blanco
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Nota"
                )
            }
        },

        floatingActionButtonPosition = androidx.compose.material3.FabPosition.End
    ) { pad ->

        Column(
            modifier = Modifier.padding(pad),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn {
                items(datos) { item ->
                    CardNote(
                        title = item.title,
                        note = item.note,
                        date = item.date
                    ) {
                        navController.navigate("EditNoteView/${item.idDoc}")
                    }
                }
            }
        }

    }
}
