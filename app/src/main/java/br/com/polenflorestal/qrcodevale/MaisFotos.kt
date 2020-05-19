package br.com.polenflorestal.qrcodevale

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MaisFotos : AppCompatActivity() {
    private val maisFotos = hashMapOf<String, Array<Int>>()
    var btprevious: Button? = null
    var btnext: Button? = null
    var myImage: ImageView? = null
    var i = 0
    var codigo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mais_fotos)

        codigo = intent.getStringExtra("codigo")
        codigo = codigo.toLowerCase()

        Log.i("MY_MAISFOTOS", "codigo: $codigo")

        btprevious = findViewById(R.id.button1);
        btnext = findViewById(R.id.button2);
        myImage = findViewById(R.id.myImage);

        maisFotos["p2089b338a1"] =
            arrayOf(R.drawable.p2089b338a1_2, R.drawable.p2089b338a1_3, R.drawable.p2089b338a1_4)

        Log.i("MY_MAISFOTOS", "hashMap: " + maisFotos[codigo])

        if(maisFotos.containsKey(codigo))
            changeImage()
    }

    fun btnAnterior(view: View) {
        if (maisFotos.containsKey(codigo)) {
            if (maisFotos[codigo]?.size ?: 0 > 0) {
                i--
                if (i <= 0) {
                    i = 0
                }
                changeImage()
            }
        }
        Log.i("MY_MAISFOTOS", "codigo: $i")
    }

    fun btnProxima(view: View) {
        if (maisFotos.containsKey(codigo)) {
            if (maisFotos[codigo]?.size ?: 0 > 0) {
                i++
                if (i >= maisFotos[codigo]!!.size) {
                    i = maisFotos[codigo]!!.size - 1
                }
                changeImage()
            }
        }
        Log.i("MY_MAISFOTOS", "codigo: $i")
    }

    fun changeImage() {
        myImage = findViewById(R.id.myImage)
        if (i >= 0 && i <= maisFotos[codigo]!!.size) {
            myImage!!.setImageResource(maisFotos[codigo]!![i])
        }
    }


}
