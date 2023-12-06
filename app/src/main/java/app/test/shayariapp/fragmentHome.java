package app.test.shayariapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;
import java.util.zip.Inflater;

import app.test.shayariapp.adapter.homeAdapter;
import app.test.shayariapp.model.homeModel;


public class fragmentHome extends Fragment {

    RecyclerView recyclerView;

    public fragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        homeModel[] homeModel = new homeModel[]
                {        // Inflate the layout for this fragment


                        new homeModel("પળે પળ વીતે કેવી રીતે હું જ જાણું છું, ઘૂંટાયેલી ઘડીઓની વાત હું જ જાણું છું, એકલતા હોય કેવી એ મને સમજાય છે"),
                        new homeModel("મારે એ પૂછવું હતું કે આ ભૂખ ના લીધે પેટમાં ઉંદર દોડતા હોય છે ને..? તો એમાંથી કોઈ 1st કે 2nd પણ આવે છે કે બસ એમ જ દોડ્યા કરે છે"),
                        new homeModel("તને જન્મદિવસની ખૂબ ખૂબ શુભેચ્છાઓ અને આગામી વર્ષ માટેની શુભેચ્છાઓ. આવા સાચા મિત્ર બનવા બદલ આભાર!"),
                        new homeModel("❛ તમે પાંખો કાપી ને આભ અકબંધ રાખ્યું, ને એનું તે નામ તમે સંબંધ રાખ્યું. મારા સઘળાં દુવારને કરી દીધાં બંધ, ને આમ તમે આંખોને કરી દીધી અંધ. તમે કાંટાળા થોરનો આપ્યો મને સ્પર્શ, ને એનું તે નામ તમે સુગંધ રાખ્યું. હું તો વહેણમાં તણાઈ મને કાંઠો નથી, ને આપણા સંબંધની કોઈ ગાંઠો નથી. અછાંદસ જેવો છે આપણો આ પંથ, ને એનું તે નામ તમે છંદ રાખ્યું. ❜ - પન્ના નાયક"),
                        new homeModel("હું બધું જ જાણું છું પણ ચુપ છું, કોઈ પોતાના મતલબ માટે કેટલી હદ વટાવે એ જોવ છું\uD83D\uDE0E\n "),
                        new homeModel("હશે જો એને પ્રેમ \uD83D\uDC91 તો સામે થી આવશે એ.. પ્રેમ મા પાગલ બનાય દોસ્ત , ભીખારી નહી \uD83D\uDE06\n"),
                        new homeModel("મમ્મી: શું કરે છે બેટા?.. ચિન્ટુ: વાચુ છું મમ્મી.. મમ્મી: સરસ બેટા.. શું વાચે છે?.. ચિન્ટુ: તમારી આવનારી વહુના મેસેજ.. 4G ની સ્પીડે આવ્યું ચંપલ \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE1B\n"),
                        new homeModel("પળે પળ વીતે કેવી રીતે હું જ જાણું છું, ઘૂંટાયેલી ઘડીઓની વાત હું જ જાણું છું, એકલતા હોય કેવી એ મને સમજાય છે"),
                        new homeModel("મારે એ પૂછવું હતું કે આ ભૂખ ના લીધે પેટમાં ઉંદર દોડતા હોય છે ને..? તો એમાંથી કોઈ 1st કે 2nd પણ આવે છે કે બસ એમ જ દોડ્યા કરે છે"),
                        new homeModel("તને જન્મદિવસની ખૂબ ખૂબ શુભેચ્છાઓ અને આગામી વર્ષ માટેની શુભેચ્છાઓ. આવા સાચા મિત્ર બનવા બદલ આભાર!"),
                        new homeModel("❛ તમે પાંખો કાપી ને આભ અકબંધ રાખ્યું, ને એનું તે નામ તમે સંબંધ રાખ્યું. મારા સઘળાં દુવારને કરી દીધાં બંધ, ને આમ તમે આંખોને કરી દીધી અંધ. તમે કાંટાળા થોરનો આપ્યો મને સ્પર્શ, ને એનું તે નામ તમે સુગંધ રાખ્યું. હું તો વહેણમાં તણાઈ મને કાંઠો નથી, ને આપણા સંબંધની કોઈ ગાંઠો નથી. અછાંદસ જેવો છે આપણો આ પંથ, ને એનું તે નામ તમે છંદ રાખ્યું. ❜ - પન્ના નાયક"),
                        new homeModel("હું બધું જ જાણું છું પણ ચુપ છું, કોઈ પોતાના મતલબ માટે કેટલી હદ વટાવે એ જોવ છું\uD83D\uDE0E\n "),
                        new homeModel("હશે જો એને પ્રેમ \uD83D\uDC91 તો સામે થી આવશે એ.. પ્રેમ મા પાગલ બનાય દોસ્ત , ભીખારી નહી \uD83D\uDE06\n"),
                        new homeModel("મમ્મી: શું કરે છે બેટા?.. ચિન્ટુ: વાચુ છું મમ્મી.. મમ્મી: સરસ બેટા.. શું વાચે છે?.. ચિન્ટુ: તમારી આવનારી વહુના મેસેજ.. 4G ની સ્પીડે આવ્યું ચંપલ \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE1B\n"),          new homeModel("મમ્મી: શું કરે છે બેટા?.. ચિન્ટુ: વાચુ છું મમ્મી.. મમ્મી: સરસ બેટા.. શું વાચે છે?.. ચિન્ટુ: તમારી આવનારી વહુના મેસેજ.. 4G ની સ્પીડે આવ્યું ચંપલ \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE1B\n"),
                        new homeModel("મમ્મી: શું કરે છે બેટા?.. ચિન્ટુ: વાચુ છું મમ્મી.. મમ્મી: સરસ બેટા.. શું વાચે છે?.. ચિન્ટુ: તમારી આવનારી વહુના મેસેજ.. 4G ની સ્પીડે આવ્યું ચંપલ \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE1B\n"),

                };
        recyclerView = rootView.findViewById(R.id.recyclerView_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        homeAdapter adapter = new homeAdapter(homeModel, getActivity());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}