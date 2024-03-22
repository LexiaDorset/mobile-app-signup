package com.stu74526.lab1_74526

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val lightGray = Color.LightGray
val white = Color.White
val black = Color.Black
val lightBlack = Color.DarkGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            gLogin() // Light login page
            //bLogin() // Dark login page
            //gSignUp() // Light sign up page
            //bSignUp() // Dark sign up page
        }
    }
}
@Composable
fun gLogin()
{
    MainLogin(lightGray, white, lightBlack, black)
}

@Composable
fun gSignUp()
{
    MainSignUp(lightGray, white, lightBlack, black)
}

@Composable
fun bLogin()
{
    MainLogin(black, lightBlack, lightGray, white)
}

@Composable
fun bSignUp()
{
    MainSignUp(black, lightBlack, lightGray, white)
}

@Composable
fun MainSignUp(mainColor : Color,
               secondColor: Color,
               thirdColor: Color,
               fourColor: Color) // Main function for sign up page
{
    Column (modifier = Modifier
        .background(mainColor)
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        // Logo with image of lock screen
        ShowImage(R.drawable.imagelogin,Modifier.padding(bottom=30.dp))

        // First Text for welcome the user
        MainText("Let's create an account for you!",thirdColor)

        // Part with TextField, Login Button and icons
        BoxesPartSign(secondColor, thirdColor, fourColor)

        // End with Text
        FinalPart("Already a member?"," Login now",
            thirdColor, modifier = Modifier.padding(top = 35.dp))
    }
}

@Composable
fun BoxesPartSign(sColor: Color, tColor: Color, fColor: Color) // Text fields and Sign Up Button
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 50.dp, end = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextFieldPartSignUp(sColor, tColor)
        BigButton("Sign Up", sColor, fColor)
    }
}
@Composable
fun TextFieldPartSignUp(sColor: Color, tColor: Color) // Text fields for email, password and confirm
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(bottom = 20.dp)
        ,horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        RoundedTextField("Email",
            Modifier
                .fillMaxWidth(), sColor, tColor)
        RoundedTextField("Password",
            Modifier
                .fillMaxWidth(),sColor, tColor)
        RoundedTextField("Confirm Password",
            Modifier
                .fillMaxWidth(),sColor, tColor)
    }
}

@Composable
fun MainLogin(mainColor : Color,
              secondColor: Color,
              thirdColor: Color,
              fourColor: Color) // Main function for login page
{
    Column (modifier = Modifier
        .background(mainColor)
        .fillMaxHeight()
        .fillMaxWidth()
        ,horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        // Logo with image of lock screen
        ShowImage(R.drawable.imagelogin,Modifier.padding(bottom=30.dp))

        // First Text for welcome the user
        MainText("Welcome back you've been missed!",thirdColor)

        // Part with TextField, Login Button and icons
        SecondPart(secondColor, thirdColor, fourColor)

        // End with Text
        FinalPart("Not a member?",
            " Register now",thirdColor)
    }
}

@Composable
fun FinalPart(firstString: String, secondString: String,
              tColor: Color, modifier: Modifier = Modifier) // Text ask if you're not a member, register now
{
    Row(modifier = modifier)
    {
        CustomText(textString = firstString, color = tColor,
            fontSize = 13.sp,fontWeight = FontWeight.Normal)
        CustomText(textString = secondString, color = tColor,
            fontSize = 13.sp,fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MainText(textString: String,tColor: Color) // Main text for welcome the user
{
    Column (modifier = Modifier.padding(bottom = 15.dp)
        .fillMaxWidth()
        ,horizontalAlignment = Alignment.CenterHorizontally)
    {
        CustomText(textString,
            color= tColor,
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium)
    }
}

@Composable
fun SecondPart(sColor:Color, tColor: Color, fColor: Color) // Text fields, Login Button and google and apple icons
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 50.dp, end = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        BoxesPart(sColor, tColor, fColor)
        EndPart(sColor, tColor)
    }
}

@Composable
fun EndPart(sColor: Color, tColor: Color) // End of the second part, with text and icons
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 15.dp)
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        TextWithBoxes("Or continue with", tColor)
        LogoIcon(sColor, tColor)
    }
}

@Composable
fun LogoIcon(sColor: Color, tColor: Color) // Google and Apple icons in a row
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically)
    {
        ButtonIcons(R.drawable.googleicon, sColor, tColor)
        ButtonIcons(R.drawable.appleicon, sColor, tColor)
    }
}

@Composable
fun ButtonIcons(drawable: Int, sColor: Color, tColor: Color) // Button with icons
{
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(sColor),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.size(70.dp)
            .border(1.dp, tColor, RoundedCornerShape(8.dp))
    )
    {
        ShowImage(drawable)
    }
}

@Composable
fun ShowImage(drawable: Int, modifier: Modifier = Modifier) // Show image
{
    Image(
        painter = painterResource(id = drawable),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun BoxesPart(sColor: Color, tColor: Color, fColor: Color) // Text fields and Login Button
{
    Column(modifier = Modifier
        .fillMaxWidth()
        , horizontalAlignment = Alignment.CenterHorizontally) {
        TextFieldPart(sColor, tColor)
        TextPassword(tColor)
        BigButton("Login",sColor, fColor)
    }
}

@Composable
fun TextPassword(tColor: Color) // Text for forgot password
{
    Row(modifier = Modifier.fillMaxWidth())
    {
        Spacer(modifier = Modifier.weight(1f))
        CustomText("Forgot Password?",
            textAlign = TextAlign.Right,
            modifier = Modifier.padding(bottom = 18.dp),
            fontWeight = FontWeight.Bold,
            color = tColor)
    }
}

@Composable
fun TextFieldPart(sColor: Color, tColor: Color) // Text fields for email and password
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        RoundedTextField("Email",
            Modifier
                .fillMaxWidth(), sColor, tColor)
        RoundedTextField("Password",
            Modifier
                .fillMaxWidth(),sColor, tColor)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedTextField(textString: String, modifier: Modifier,
                     sColor: Color, tColor: Color) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        modifier = modifier,
        colors = TextFieldDefaults.outlinedTextFieldColors
            ( focusedBorderColor = tColor,
            unfocusedBorderColor = tColor,
            focusedPlaceholderColor = tColor,
            unfocusedPlaceholderColor = tColor,
            containerColor = sColor),
        placeholder = { Text(text = textString) },
    )
}

@Composable
fun BigButton(textString: String, sColor: Color, fColor: Color) // Login or Sign Up Button
{
    Button(
        onClick = {}, Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(sColor),
        )
    {
        CustomText(textString, color= fColor,
            fontSize = 20.sp,fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all=10.dp))
    }
}

@Composable
fun TextWithBoxes(textString: String, sColor: Color) // Text between two boxes
{
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically)
    {
        Box(modifier = Modifier
            .weight(1f)
            .width(100.dp)
            .height(1.dp)
            .background(sColor))

        CustomText(textString = textString, color = sColor,
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 14.sp)

        Box(modifier = Modifier
            .weight(1f)
            .width(100.dp)
            .height(1.dp)
            .background(sColor))
    }
}

@Composable
fun CustomText(textString: String,
               color: Color = Color.Black,
               fontSize: TextUnit = 12.sp,
               fontWeight: FontWeight = FontWeight.Normal,
               textAlign : TextAlign = TextAlign.Center,
               @SuppressLint("ModifierParameter")
               modifier: Modifier = Modifier) // Custom Text with default parameters
{
    Text(
        text = textString,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign)
}
