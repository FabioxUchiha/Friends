package com.electiva1.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_detalles.*

class DetallesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detalles, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val act = activity
        if(act?.intent != null) {
            val famousName = act.intent.getStringExtra("famous_name") ?: "a"
            displayFamous(famousName)

           /* val click = findViewById()indViewById<Button>(R.id.button) as Button
            val ratingBar = findViewById<RatingBar>(R.id.rating) as RatingBar

            click.setOnClickListener {
                val ratingBarValue = ratingBar.rating
                Toast.makeText(this@MainActivity,"Calificacion :- "+ratingBarValue, Toast.LENGTH_SHORT).show()

            }
            */
        }
    }



    fun displayFamous(famousName: String) {
        val imageID = resources.getIdentifier(famousName.toLowerCase(), "drawable",activity!!.packageName)
        val textFileID = resources.getIdentifier(famousName.toLowerCase(), "raw", activity!!.packageName)
        val fileText = resources.openRawResource(textFileID).bufferedReader().readText()
        famous_name.text = famousName
        famous_image.setImageResource(imageID)
        famous_detail.text = fileText


    }

}
