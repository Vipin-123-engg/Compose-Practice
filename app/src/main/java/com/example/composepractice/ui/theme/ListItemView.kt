package com.example.composepractice.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.models.UserDetails

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListItemView(userDetails: UserDetails) {
    Card(
        elevation = CardDefaults.cardElevation(draggedElevation = 10.dp),
border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth().padding(5.dp)
    ) {
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            Image(
                painter = painterResource(id = userDetails.profilePhoto),
                contentDescription = "",
                modifier = Modifier.width(100.dp).clip(CircleShape)
            )
            Column {
                Text(
                    text = userDetails.name, modifier = Modifier
                        .padding(10.dp, 10.dp)
                        .fillMaxWidth()
                    , style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
                Text(
                    text = userDetails.description, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp), style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
            }

        }
    }

}