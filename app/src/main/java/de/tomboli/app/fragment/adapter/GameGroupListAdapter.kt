package de.tomboli.app.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import de.tomboli.app.R
import de.tomboli.app.databinding.GameGroupItemBinding
import de.tomboli.app.fragment.GameGroupsFragmentDirections
import de.tomboli.app.model.GameInfo
import de.tomboli.app.model.GamesGroup
import de.tomboli.app.model.User

private const val MAX_GAME_BUTTONS = 3

class GameGroupListAdapter() :
    RecyclerView.Adapter<GameGroupListAdapter.GameGroupViewHolder>() {

    private val groups: List<GamesGroup>

    init {
        groups = mutableListOf(
            GamesGroup(
                "2",
                "Familie",
                mutableListOf(User("1", "Vater"), User("1", "Mutter")),
                mutableListOf(
                    GameInfo("Poker"),
                    GameInfo("BlackJack"),
                    GameInfo("ChicagoFire"),
                    GameInfo("LoopingLoui")
                )
            ),
            GamesGroup(
                "2",
                "Familie2",
                mutableListOf(User("1", "Vater")),
                mutableListOf(GameInfo("Poker"), GameInfo("Uno"))
            )
        )
    }

    class GameGroupViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val binding = GameGroupItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGroupViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.game_group_item, parent, false)
        return GameGroupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    override fun onBindViewHolder(holder: GameGroupViewHolder, position: Int) {
        val gamesGroup = groups[position]
        holder.binding.gamesGroup = gamesGroup
        val supportString = holder.itemView.context.resources.getString(
            R.string.game_groups_member_prefix,
            gamesGroup.member.size
        )
        holder.binding.txtMemberCount.text = supportString
        getGameButtons(holder, gamesGroup)
        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView, "Clicked on ${gamesGroup.name}", Snackbar.LENGTH_SHORT)
                .show()
            val action =
                GameGroupsFragmentDirections.actionGameGroupsFragmentToGameGroupSettingsFragment(
                    gamesGroup
                )
            findNavController(holder.itemView).navigate(action)
        }
//        holder.binding.gameGroupSettingsButton.setOnClickListener {
//            findNavController(holder.itemView).navigate(R.id.action_GameGroupsFragment_to_GameGroupSettingsFragment)
//        }
    }

    private fun getGameButtons(holder: GameGroupViewHolder, gameGroup: GamesGroup) {
        gameGroup.games.take(MAX_GAME_BUTTONS).forEach {
            val button = LayoutInflater.from(holder.itemView.context).inflate(
                R.layout.game_group_game_button,
                holder.binding.llGameButtons,
                false
            ) as MaterialButton
            button.text = it.name
            holder.binding.llGameButtons.addView(button)
        }
    }
}

