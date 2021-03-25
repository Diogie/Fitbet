package com.fitbet

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.recyclerview.widget.RecyclerView
import com.fitbet.data.entity.Challenge
import com.fitbet.databinding.ChallengeCardBinding
import com.fitbet.ui.ChallengeActivity

class ChallengeAdapter(
    private var challenges: List<Challenge>,
    private val startForResult: ActivityResultLauncher<Intent>
): RecyclerView.Adapter<ChallengeAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemBinding = ChallengeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(itemBinding, parent.context)
    }

    override fun getItemCount(): Int = challenges.count()

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val challenge: Challenge = challenges[position]
        holder.bind(challenge, startForResult)
    }

    fun setData(newData: List<Challenge>) {
        this.challenges = newData
        notifyDataSetChanged()
    }

    class CardViewHolder(
        private val itemBinding: ChallengeCardBinding,
        private val context: Context) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(challenge: Challenge, startForResult: ActivityResultLauncher<Intent>) {
            itemBinding.challengeId.text = challenge.challengeId.toString()
            itemBinding.challengeCard.setOnClickListener {
                val intent = Intent(context, ChallengeActivity::class.java)
                intent.putExtra("CHALLENGE_ID", challenge.challengeId)
                startForResult.launch(intent)
            }
        }
    }
}