package home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.nu_therabbit.bottombarproject.R
import common.AbstractFragment

class DefaultOneFragment : AbstractFragment() {
    companion object {
        fun newInstance(): DefaultOneFragment {
            val bundle = Bundle()
            val fragment = DefaultOneFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var button: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.btn_recycle)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button?.setOnClickListener(View.OnClickListener {
            start(views.RecyclerViewFragment.newInstance())
        })

    }

}