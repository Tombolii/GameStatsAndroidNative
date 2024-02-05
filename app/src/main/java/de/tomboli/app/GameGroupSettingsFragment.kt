package de.tomboli.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import de.tomboli.app.databinding.GameGroupSettingsFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GameGroupSettingsFragment : Fragment() {

    private var _binding: GameGroupSettingsFragmentBinding? = null

    val args: GameGroupSettingsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = GameGroupSettingsFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_GameGroupSettingsFragment_to_GameGroupsFragment)
        }

        binding.groupNameInput.editText?.setText(args.gameGroup.name)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}