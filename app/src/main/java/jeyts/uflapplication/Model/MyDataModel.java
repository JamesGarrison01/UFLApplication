package jeyts.uflapplication.Model;

public class MyDataModel {

    private String name;
    private String teamName;
    private String Completions;
    private String Attempts,	passTouchdowns,	Interceptions,	passingUnits;
    private String Catches, receiveTouchdowns, receiveUnits,	Tackles, defInterception, forceFumble;
    private String fumbleRecovery,	Sacks,	Deflections,	defTD,	rushTouchdowns,	rushUnits;
    private String Rushes;
    private String fgMade;
    private String fgTry;
    private String kickRTD;
    private String date;
    private String time2;
    private String Game;

    public void setGame(String game){
        Game = game;
    }

    public String getGame(){
        return Game;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time) {
        this.time2 = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    public MyDataModel(String teamName){
        this.teamName = teamName;
    }

    public String dateDetails(){
        return Game + "\nTime: "  + time2 + "\nLocation: " + location;
    }

    public String playersStats(){
        return teamName + "\n" + "Completions: " + Completions + "\nAttempts: " + Attempts + "\nPassing Touchdowns: "
                + passTouchdowns+ "\nInterceptions: " + Interceptions+ "\nPassing Units: " + passingUnits
                + "\nCatches: " + Catches + "\nReceiving Touchdowns: " + receiveTouchdowns + "\nReceiving Units: " + receiveUnits
                + "\nTackles: " + Tackles + "\nDefensive Interception: " + defInterception + "\nForced Fumble: "
                + forceFumble + "\nFumble Recovery" + fumbleRecovery + "\nSacks: " + Sacks + "\nDeflections: " + Deflections
                + "\nDefnsive Touchdowns: " + defTD + "\nRushing Touchdowns: " + rushTouchdowns + "\nRushing Units: "
                + rushUnits + "\nRushes: " + Rushes + "\nField Goals Made: " + fgMade + "\nField Goals Attempted: " + fgTry + "\nKickoff Return TDs: " +kickRTD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCompletions() {
        return Completions;
    }

    public void setCompletions(String completions) {
        Completions = completions;
    }

    public String getAttempts() {
        return Attempts;
    }

    public void setAttempts(String attempts) {
        Attempts = attempts;
    }

    public String getPassTouchdowns() {
        return passTouchdowns;
    }

    public void setPassTouchdowns(String passTouchdowns) {
        this.passTouchdowns = passTouchdowns;
    }

    public String getInterceptions() {
        return Interceptions;
    }

    public void setInterceptions(String interceptions) {
        Interceptions = interceptions;
    }

    public String getPassingUnits() {
        return passingUnits;
    }

    public void setPassingUnits(String passingUnits) {
        this.passingUnits = passingUnits;
    }

    public String getCatches() {
        return Catches;
    }

    public void setCatches(String catches) {
        Catches = catches;
    }

    public String getReceiveTouchdowns() {
        return receiveTouchdowns;
    }

    public void setReceiveTouchdowns(String receiveTouchdowns) {
        this.receiveTouchdowns = receiveTouchdowns;
    }

    public String getReceiveUnits() {
        return receiveUnits;
    }

    public void setReceiveUnits(String receiveUnits) {
        this.receiveUnits = receiveUnits;
    }

    public String getTackles() {
        return Tackles;
    }

    public void setTackles(String tackles) {
        Tackles = tackles;
    }

    public String getDefInterception() {
        return defInterception;
    }

    public void setDefInterception(String defInterception) {
        this.defInterception = defInterception;
    }

    public String getForceFumble() {
        return forceFumble;
    }

    public void setForceFumble(String forceFumble) {
        this.forceFumble = forceFumble;
    }

    public String getFumbleRecovery() {
        return fumbleRecovery;
    }

    public void setFumbleRecovery(String fumbleRecovery) {
        this.fumbleRecovery = fumbleRecovery;
    }

    public String getSacks() {
        return Sacks;
    }

    public void setSacks(String sacks) {
        Sacks = sacks;
    }

    public String getDeflections() {
        return Deflections;
    }

    public void setDeflections(String deflections) {
        Deflections = deflections;
    }

    public String getDefTD() {
        return defTD;
    }

    public void setDefTD(String defTD) {
        this.defTD = defTD;
    }

    public String getRushTouchdowns() {
        return rushTouchdowns;
    }

    public void setRushTouchdowns(String rushTouchdowns) {
        this.rushTouchdowns = rushTouchdowns;
    }

    public String getRushUnits() {
        return rushUnits;
    }

    public void setRushUnits(String rushUnits) {
        this.rushUnits = rushUnits;
    }

    public String getRushes() {
        return Rushes;
    }

    public void setRushes(String rushes) {
        Rushes = rushes;
    }

    public String getFgMade() {
        return fgMade;
    }

    public void setFgMade(String fgMade) {
        this.fgMade = fgMade;
    }

    public String getFgTry() {
        return fgTry;
    }

    public void setFgTry(String fgTry) {
        this.fgTry = fgTry;
    }

    public String getKickRTD() {
        return kickRTD;
    }

    public void setKickRTD(String kickRTD) {
        this.kickRTD = kickRTD;
    }



}

