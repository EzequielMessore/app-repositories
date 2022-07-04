package br.com.dio.app.repositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FieldClassification
import br.com.dio.app.repositories.R
import br.com.dio.app.repositories.data.model.Repo
import br.com.dio.app.repositories.databinding.ActivityDetailsBinding
import br.com.dio.app.repositories.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    object Extras{
        const val REPO = "EXTRA_REPO"
    }

    private val binding by lazy { ActivityDetailsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra() {
        intent?.extras?.getParcelable<Repo>(Extras.REPO)?.let {
            Glide.with(this)
                .load(it.owner.avatarURL)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.ivOwner)

            binding.tvRepoName.text = it.name
            binding.tvRepoLanguage.text = it.language
            binding.chipStar.text = it.stargazersCount.toString()
            binding.tvRepoDescription.text = it.description
        }
    }

}