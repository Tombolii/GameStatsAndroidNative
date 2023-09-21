package de.tomboli.app.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import de.tomboli.app.R
import de.tomboli.app.databinding.GameGroupItemBinding
import de.tomboli.app.model.GamesGroup

class GameGroupListAdapter() : ListAdapter<GamesGroup, GameGroupListAdapter.GameGroupViewHolder>(DiffCallback) {

    class GameGroupViewHolder(private var binding: GameGroupItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(gamesGroup: GamesGroup) {
            binding.groupName.text = gamesGroup.name
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GamesGroup>() {
        override fun areItemsTheSame(oldItem: GamesGroup, newItem: GamesGroup): Boolean {
            return oldItem.gamesGroupId == newItem.gamesGroupId
        }

        override fun areContentsTheSame(oldItem: GamesGroup, newItem: GamesGroup): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGroupViewHolder {
        return GameGroupViewHolder(
            GameGroupItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: GameGroupViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            //onItemClicked(current)
            val mySnackbar = Snackbar.make(it, R.string.app_name, 3)
            mySnackbar.show()
        }
    }

}
