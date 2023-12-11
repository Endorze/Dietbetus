package com.example.dietbetus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentInformativeLinksBinding

class InformativeLinksFragment : Fragment() {

    private lateinit var binding: FragmentInformativeLinksBinding
    val video = "wZAjVQWbMlE"
    val diabetes1 = "C3AQIfgthh4"
    val diabetes2 = "4SZGM_E5cLI"
    val symptoms = "L06DNMRcy98"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformativeLinksBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            playYoutubeVideo(video)
        }
        binding.button1.setOnClickListener {
            playYoutubeVideo(diabetes1)
        }
        binding.button2.setOnClickListener {
            playYoutubeVideo(diabetes2)
        }
        binding.symptomsButton.setOnClickListener {
            playYoutubeVideo(symptoms)
        }










        return binding.root
    }
    fun playYoutubeVideo(uri: String) {
            val videoUri: Uri = Uri.parse("vnd.youtube:$uri")
            val intent = Intent(Intent.ACTION_VIEW, videoUri)
            startActivity(intent)
    }
}