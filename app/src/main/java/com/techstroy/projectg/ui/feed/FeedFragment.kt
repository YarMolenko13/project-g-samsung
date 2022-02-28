package com.techstroy.projectg.ui.feed

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.techstroy.projectg.R
import com.techstroy.projectg.databinding.FeedFragmentBinding


class FeedFragment : Fragment() {

    private lateinit var binding: FeedFragmentBinding

    companion object {
        fun newInstance() = FeedFragment()
    }

    abstract class AppBarStateChangeListener : OnOffsetChangedListener {
        enum class State {
            EXPANDED, COLLAPSED, IDLE
        }

        private var mCurrentState = State.IDLE
        override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
            mCurrentState = if (i == 0) {
                if (mCurrentState != State.EXPANDED) {
                    onStateChanged(appBarLayout, State.EXPANDED)
                }
                State.EXPANDED
            } else if (Math.abs(i) >= appBarLayout.totalScrollRange) {
                if (mCurrentState != State.COLLAPSED) {
                    onStateChanged(appBarLayout, State.COLLAPSED)
                }
                State.COLLAPSED
            } else {
                if (mCurrentState != State.IDLE) {
                    onStateChanged(appBarLayout, State.IDLE)
                }
                State.IDLE
            }
        }

        abstract fun onStateChanged(appBarLayout: AppBarLayout?, state: State?)
    }

    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FeedFragmentBinding.inflate(inflater)

        val adapter = MatchChipsAdapter()

        val match1 = MatchChipData(id=1, date="12:42")
        val match2 = MatchChipData(id=2, date="15:22")
        val match3 = MatchChipData(id=3, date="17:51")
        val matches = listOf(match1, match2, match3, MatchChipData(id=4, date="21:10"))

        binding.matchChips.adapter = adapter

        adapter.submitList(matches)

        binding.appBarLayout.addOnOffsetChangedListener(object: AppBarStateChangeListener() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                state?.let {
                    if (it.name == "COLLAPSED") {
                        binding.scrollBody.background = resources.getDrawable(R.color.white, null)
                    } else {
                        binding.scrollBody.background = resources.getDrawable(R.drawable.feed_body_bg, null)
                    }
                }
            }
        })


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}