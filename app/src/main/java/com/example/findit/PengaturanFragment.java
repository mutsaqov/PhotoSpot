package com.example.findit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PengaturanFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PengaturanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PengaturanFragment extends Fragment {

    ListView about_app;
    ImageView Admin_Login;
  //  Button btn_maps;

    // TODO: Rename parameter arguments, choose names that match


    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;

    public PengaturanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PengaturanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PengaturanFragment newInstance(String param1, String param2) {
        PengaturanFragment fragment = new PengaturanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pengaturan, container, false);


        Admin_Login = (ImageView) view.findViewById(R.id.adminlog);
        Admin_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLoadNewActivity = new Intent(v.getContext(), LoginAdmin.class);
                startActivity(intentLoadNewActivity);
            }
        });

        about_app = (ListView) view.findViewById(R.id.list1);
        String[] values = new String[]{"Tentang Aplikasi","Hubungi Kami" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, values);

        about_app.setAdapter(adapter);

        about_app.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    AboutAppDialog1();
                }

                if(position == 1) {
                    CallusDialog1();
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    } */

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void AboutAppDialog1(){
        final Dialog MyDialog1 = new Dialog(getActivity());
        MyDialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog1.setContentView(R.layout.aboutapp);

        Button close = (Button)MyDialog1.findViewById(R.id.close);
        close.setEnabled(true);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog1.cancel();
            }
        });
        MyDialog1.show();
    }

    public void CallusDialog1(){
        final Dialog MyDialog1 = new Dialog(getActivity());
        MyDialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog1.setContentView(R.layout.aboutapp);

        Button close = (Button)MyDialog1.findViewById(R.id.close);
        close.setEnabled(true);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog1.cancel();
            }
        });
        MyDialog1.show();
    }


}
