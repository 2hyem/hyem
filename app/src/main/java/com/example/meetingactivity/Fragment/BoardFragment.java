package com.example.meetingactivity.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetingactivity.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BoardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoardFragment extends Fragment implements View.OnClickListener {

    ImageButton noticeButton;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Animation fab_open,fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2;
    LinearLayout fabLayout,fabLayout1,fabLayout2,boardLayout;
    LinearLayout inputLayout;
    TextView textFab1,textFab2;



    public BoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BoardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BoardFragment newInstance(String param1, String param2) {
        BoardFragment fragment = new BoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        fab_open= AnimationUtils.loadAnimation(getActivity(),R.anim.fab_open);
        fab_close=AnimationUtils.loadAnimation(getActivity(),R.anim.fab_close);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view =inflater.inflate(R.layout.fragment_board, container, false);
        fab=(FloatingActionButton) view.findViewById(R.id.fab);
        fab1=(FloatingActionButton)view.findViewById(R.id.fab1);
        fab2=(FloatingActionButton)view.findViewById(R.id.fab2);

        textFab1=view.findViewById(R.id.textFab1);
        textFab2=view.findViewById(R.id.textFab2);

        fabLayout=view.findViewById(R.id.fabLayout);
        fabLayout1=view.findViewById(R.id.fabLayout1);
        fabLayout2=view.findViewById(R.id.fabLayout2);

        boardLayout=view.findViewById(R.id.boardLayout);
        inputLayout=view.findViewById(R.id.inputLayout);


        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                anim();
                break;
            case R.id.fab1:
                anim();
                boardLayout.setVisibility(View.GONE);
                fabLayout.setVisibility(View.GONE);
                inputLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.fab2:
                anim();
                Toast.makeText(getActivity(),"button2",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void anim() {
                if (isFabOpen) {
                        fab.animate().rotationBy(60);
                        fab1.startAnimation(fab_close);
                        fab2.startAnimation(fab_close);
                        fabLayout1.setVisibility(View.GONE);
                        fabLayout2.setVisibility(View.GONE);
                        fab1.setClickable(false);
                        fab2.setClickable(false);
                         isFabOpen = false;
                     } else {
                    fab.animate().rotationBy(-60);

                         fab1.startAnimation(fab_open);
                         fab2.startAnimation(fab_open);
                        fabLayout1.setVisibility(View.VISIBLE);
                        fabLayout2.setVisibility(View.VISIBLE);
                         fab1.setClickable(true);
                         fab2.setClickable(true);
                         isFabOpen = true;
                     }
             }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
