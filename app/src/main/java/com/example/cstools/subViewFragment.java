package com.example.cstools;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link subViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class subViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public subViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment subViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static subViewFragment newInstance(String param1, String param2) {
        subViewFragment fragment = new subViewFragment();
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
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View sRootViewe =inflater.inflate(R.layout.fragment_sub_view, container, false);

        Bundle bundleSub = getArguments();
        String net1 = bundleSub.getString("sa1").toString();
        String net2 = bundleSub.getString("sa2").toString();
        String net3 = bundleSub.getString("sa3").toString();
        String net4 = bundleSub.getString("sa4").toString();
        String sAm  = bundleSub.getString("sAmount");
        int Amount  = Integer.parseInt(sAm);

        String Zeros = "00000000";

        int  hosts =0;

        TextView tvsad = (TextView) sRootViewe.findViewById(R.id.tvsvad);
        TextView tvsh  = (TextView) sRootViewe.findViewById(R.id.tvsHost);

        TextView subtvadr     =(TextView) sRootViewe.findViewById(R.id.subtvAddt);
        TextView subtvTothost =(TextView) sRootViewe.findViewById(R.id.subTvTotHostt);



        //begin algorithm
        String AmountBin = Integer.toBinaryString(Amount);
        System.out.println(AmountBin.length());

        char ones[] = new char[AmountBin.length()];
        for(int i=0 ; i<AmountBin.length() ; i++) {
            ones[i] = '1';
        }

        String binString = new String(ones);


        //creating string
        String ans;
        if	(net3.equals("0") && net4.equals("0") && net2.equals("0") ) {

            System.out.println("Class A");
            if	(binString.length()>0 && binString.length()<8) {

                ans = "255 " +  Integer.parseInt( binString.substring( 0, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length()) , 2 ) + " 0" +" 0" ;
                //text formating
                hosts = Integer.parseInt( binString.substring( 0, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length()) , 2 );
                String convrt= (Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length())+"00000000" ).replace("0","1");
                String convrt2 =Integer.toString(Integer.parseInt(convrt,2));

                tvsh.setText(convrt2);
                tvsad.setText(ans);
                subtvadr.setText("Subnet Mask: ");
                subtvTothost.setText("Total Hosts:");
            }

            if	(binString.length()>=8 && binString.length()<16) {

                ans = "255 " + Integer.parseInt(binString.substring(0, 8), 2)+" " + Integer.parseInt( binString.substring( 8, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 8, binString.length() ).length()) , 2 ) +" 0";
                //text formating
                String convrt =Zeros.substring(0, Zeros.length()-binString.substring( 8, binString.length() ).length())+"00000000";
                String convrt1 = convrt.replace("0","1");
                String convrt2 =Integer.toString(Integer.parseInt(convrt1,2));

                tvsh.setText(convrt2);
                tvsad.setText(ans);
                subtvadr.setText("Subnet Mask: ");
                subtvTothost.setText("Total Hosts:");

            }

            if	(binString.length()>=16 && binString.length()<24) {

                ans = "255 " + Integer.parseInt(binString.substring(0, 8), 2)+" " + Integer.parseInt( binString.substring( 8, 16 ),2  ) +" "+Integer.parseInt( binString.substring( 16, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 16, binString.length() ).length()) , 2 );
                String convrt =Zeros.substring(0, Zeros.length()-binString.substring( 16, binString.length() ).length());
                String convrt1= convrt.replace("0","1");
                String convrt2= Integer.toString(Integer.parseInt(convrt1,2));

                subtvadr.setText("Subnet Mask: ");
                tvsh.setText( convrt2);
                tvsad.setText(ans);
                subtvTothost.setText("Total Hosts:");
            }




        }

        else if	(net3.equals("0") && net4.equals("0") ) {

            System.out.println("Class B");
            if	(binString.length()>0 && binString.length()<8) {
                ans = "255 " +"255 "+  Integer.parseInt( binString.substring( 0, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length()) , 2 ) + " 0" ;
                String convrt = Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length()) + "00000000";
                String convrt1 = convrt.replace("0","1");
                String convert2 = Integer.toString(Integer.parseInt(convrt1,2));

                subtvadr.setText("Subnet Mask: ");
                tvsh.setText(convert2);
                tvsad.setText(ans);
                subtvTothost.setText("Total Hosts:");
            }

            if	(binString.length()>8 && binString.length()<16) {

                ans = "255 " +"255 "+ Integer.parseInt(binString.substring(0, 8), 2)+" " + Integer.parseInt( binString.substring( 8, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 8, binString.length() ).length()) , 2 ) ;
                String convrt = Zeros.substring(0, Zeros.length()-binString.substring( 8, binString.length() ).length());
                String convrt1 = convrt.replace("0","1");
                String convert2 = Integer.toString(Integer.parseInt(convrt1,2));

                subtvadr.setText("Subnet Mask: ");
                tvsh.setText(convert2);
                subtvTothost.setText("Total Hosts:");
                tvsad.setText(ans);
            }


        }

        else if	(net4.equals("0")) {

            System.out.println("Class C");
            if	(binString.length()>0 && binString.length()<8) {

                ans = "255 " +"255 "+ "255"+" "+  Integer.parseInt( binString.substring( 0, binString.length() ) + Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length()) , 2 );
                tvsad.setText(ans);

                subtvadr.setText("Subnet Mask: ");
                subtvTothost.setText("Total Hosts:");

                String convrt = Zeros.substring(0, Zeros.length()-binString.substring( 0, binString.length() ).length()).replace("0","1");
                tvsh.setText(Integer.toString(Integer.parseInt(convrt,2)));
            }




        }



        return sRootViewe;
    }
}