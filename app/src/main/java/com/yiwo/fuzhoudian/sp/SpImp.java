package com.yiwo.fuzhoudian.sp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SpImp {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public SpImp(Context context) {
        sp = context.getSharedPreferences(SpPublic.SP_NAME,
                Context.MODE_PRIVATE);
        editor = sp.edit();
    }
    public String getUID() {
        return sp.getString(SpPublic.UID, "0");
    }

    public void setUID(String UID) {
        editor.putString(SpPublic.UID, UID).toString();
        editor.commit();
    }

    public String getYXID() {
        return sp.getString(SpPublic.YXID, "0");
    }

    public void setYXID(String YXID) {
        editor.putString(SpPublic.YXID, YXID).toString();
        editor.commit();
    }

    public String getYXTOKEN() {
        return sp.getString(SpPublic.YXtoken, "0");
    }

    public void setYXTOKEN(String YXTOKEN) {
        editor.putString(SpPublic.YXtoken, YXTOKEN).toString();
        editor.commit();
    }

    public String getSearch() {
        return sp.getString(SpPublic.Search, "");
    }

    public void setSearch(String search) {
        editor.putString(SpPublic.Search, search).toString();
        editor.commit();
    }

    public String getYd() {
        return sp.getString(SpPublic.Yd, "");
    }

    public void setYd(String yd) {
        editor.putString(SpPublic.Yd, yd).toString();
        editor.commit();
    }



    //长整形

    public Long getLastlogin() {
        return sp.getLong(SpPublic.LASTLOGIN, 0);
    }

    public void setLastlogin(Long lastlogin) {
        editor.putLong(SpPublic.LASTLOGIN, lastlogin);
        editor.commit();
    }
    //字符串类型
    public String getACCOUNTNO() {
        return sp.getString(SpPublic.ACCOUNTNO, "");
    }
    public void setTOKEN(String token){
        editor.putString(SpPublic.TOKEN,token).toString();
        editor.commit();
    }

    public void setACCOUNTNO(String accountno) {
        editor.putString(SpPublic.ACCOUNTNO, accountno).toString();
        editor.commit();
    }
    public String getTOKEN(){
        return sp.getString(SpPublic.TOKEN,"");
    }
    //字符串类型
    public String getPASSWORD() {
        return sp.getString(SpPublic.PASSWORD, "");
    }

    public void setPASSWORD(String password) {
        editor.putString(SpPublic.PASSWORD, password).toString();
        editor.commit();
    }
    //字符串类型
    public String getUSERINFOFLAG() {
        return sp.getString(SpPublic.USERINFOFLAG, "");
    }

    public void setUSERINFOFLAG(String userinfoflag) {
        editor.putString(SpPublic.USERINFOFLAG, userinfoflag).toString();
        editor.commit();
    }

    public void setSTATE(boolean state){
        editor.putBoolean(SpPublic.STATE,state);
        editor.commit();
    }
    public boolean getSTATE(){
        return sp.getBoolean(SpPublic.STATE,false);
    }

    //网易云上传accid
    public String getWyUpAccid() {
        return sp.getString(SpPublic.WY_UP_ACCID, "0");
    }

    public void setWyUpAccid(String wyUpAccid) {
        editor.putString(SpPublic.WY_UP_ACCID, wyUpAccid).toString();
        editor.commit();
    }
    //网易云上传token
    public String getWyUpToken() {
        return sp.getString(SpPublic.WY_UP_TOKEN, "0");
    }

    public void setWyUpToken(String wyToken) {
        editor.putString(SpPublic.WY_UP_TOKEN, wyToken).toString();
        editor.commit();
    }
    public void setIsAgreeXieYi(Boolean b){
        editor.putBoolean(SpPublic.AgreeXieYi,b);
        editor.commit();
    }
    public Boolean isAgree(){
        return sp.getBoolean(SpPublic.AgreeXieYi,false);
    }
    public String getIsAdmin(){
        return sp.getString(SpPublic.IS_ADMIN, "0");
    }
    public void setIsAdmin(String isAdmin){
        editor.putString(SpPublic.IS_ADMIN, isAdmin).toString();
        editor.commit();
    }
    public String getLiveTime(){
        return sp.getString(SpPublic.LIVE_TIME,"");
    }
    public void setLiveTime(String s){
        editor.putString(SpPublic.LIVE_TIME, s).toString();
        editor.commit();
    }

    public String getWXUnionID(){
        return sp.getString(SpPublic.WX_UNIONID,"");
    }
    public void setWXUnionID(String s){
        editor.putString(SpPublic.WX_UNIONID, s).toString();
        editor.commit();
    }

    public void setLastCreateYouJiAddress(String s){
        editor.putString(SpPublic.LAST_CREATE_YOUJI_ADDRESS, s).toString();
        editor.commit();
    }
    public String getLastCreateYouJiAddress(){
        return sp.getString(SpPublic.LAST_CREATE_YOUJI_ADDRESS,"");
    }
    public void setLastCreateYouJiLabelText(String s){
        editor.putString(SpPublic.LAST_CREATE_YOUJI_LABEL_TEXT, s).toString();
        editor.commit();
    }
    public String getLastCreateYouJiLabelText(){
        return sp.getString(SpPublic.LAST_CREATE_YOUJI_LABEL_TEXT,"");
    }
    public void setLastCreateYouJiLabelId(String s){
        editor.putString(SpPublic.LAST_CREATE_YOUJI_LABEL_ID, s).toString();
        editor.commit();
    }
    public String getLastCreateYouJiLabelId(){
        return sp.getString(SpPublic.LAST_CREATE_YOUJI_LABEL_ID,"");
    }
    public void setLastCreateVideoAddress(String s){
        editor.putString(SpPublic.LAST_CREATE_VIDEO_ADDRESS, s).toString();
        editor.commit();
    }
    public String getLastCreateVideoAddress(){
        return sp.getString(SpPublic.LAST_CREATE_VIDEO_ADDRESS,"");
    }
}
