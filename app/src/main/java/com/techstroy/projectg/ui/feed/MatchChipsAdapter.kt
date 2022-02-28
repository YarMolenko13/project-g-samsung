package com.techstroy.projectg.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.techstroy.projectg.databinding.MatchChipItemLayoutBinding

// TODO: move to another file
class MatchChipData(
    val id: Int,
    val date: String,
)

class MatchChipsAdapter: ListAdapter<MatchChipData, MatchChipsAdapter.MatchChipViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<MatchChipData>() {
        override fun areItemsTheSame(oldItem: MatchChipData, newItem: MatchChipData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MatchChipData, newItem: MatchChipData
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class MatchChipViewHolder(private val binding: MatchChipItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(matchData: MatchChipData) {
            binding.matchChip = matchData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchChipViewHolder {
        return MatchChipViewHolder(MatchChipItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: MatchChipViewHolder, position: Int) {
        val match = getItem(position)
        
        holder.bind(match)
    }
}