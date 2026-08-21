package com.example.jatpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.example.jatpack.ui.theme.JatpackTheme

// Activité principale : point d'entrée de l'application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // permet à l'app de s'afficher derrière la barre de statut/navigation (design "bord à bord")
        setContent {
            JatpackTheme { // applique le thème global de l'app (couleurs, typographie...)
                // Scaffold fournit une structure de base (gère automatiquement les zones système comme la barre de statut)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // innerPadding = espace réservé par le Scaffold pour ne pas chevaucher les barres système
                    MonArticle(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Composable principal : affiche l'article complet (image + titre + 2 paragraphes)
@Composable
fun MonArticle(modifier: Modifier = Modifier) {
    // Column empile les éléments verticalement, les uns en dessous des autres
    Column(modifier = modifier) {

        // Image d'illustration en haut de l'article
        Image(
            painter = painterResource(R.drawable.bg_compose_background), // fichier image dans res/drawable
            contentDescription = null, // pas de description car l'image est purement décorative
            contentScale = ContentScale.FillWidth, // étire l'image sur toute la largeur sans la recadrer (garde ses proportions)
            modifier = Modifier.fillMaxWidth() // l'image occupe toute la largeur de l'écran
        )

        // Titre de l'article
        Text(
            text = stringResource(R.string.titre_article), // texte récupéré depuis strings.xml
            fontSize = 24.sp, // taille de police en "scale-independent pixels" (s'adapte aux paramètres d'accessibilité)
            modifier = Modifier.padding(16.dp) // marge intérieure de 16dp sur les 4 côtés
        )

        // Premier paragraphe
        Text(
            text = stringResource(R.string.paragraphe_1),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp), // marge uniquement à gauche et à droite
            textAlign = TextAlign.Justify // texte justifié (aligné des deux côtés, comme un journal)
        )

        // Deuxième paragraphe
        Text(
            text = stringResource(R.string.paragraphe_2),
            modifier = Modifier.padding(16.dp), // marge intérieure de 16dp sur les 4 côtés
            textAlign = TextAlign.Justify
        )
    }
}

// Aperçu (Preview) : permet de visualiser le composable directement dans Android Studio, sans lancer l'émulateur
@Preview(showBackground = true)
@Composable
fun MonArticlePreview() {
    JatpackTheme {
        MonArticle()
    }
}