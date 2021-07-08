package ru.inohunk.testbottomnavigationmenu.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.inohunk.testbottomnavigationmenu.ManagedActivity
import ru.inohunk.testbottomnavigationmenu.R
import ru.inohunk.testbottomnavigationmenu.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: Button = binding.textDashboard
        textView.setOnClickListener {
            (activity as ManagedActivity).hideBottomMenu()
            findNavController().navigate(R.id.action_navigation_dashboard_to_blankFragment)
        }
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}