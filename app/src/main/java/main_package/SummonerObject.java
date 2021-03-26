package main_package;
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
public class SummonerObject {
    ApiConfig config = new ApiConfig().setKey("RGAPI-117a0eec-85db-41da-a597-89113964359b");
    RiotApi api = new RiotApi(config);

    private String name;
    private String summonerID;
    private String accountID;
    private String puuid;
    private int summonerLevel;
    private int profileIconID;
    private Summoner summoner;

    public SummonerObject() { // default constructor
    }
    public SummonerObject(String username) throws RiotApiException {
        summoner = api.getSummonerByName(Platform.NA, username);
        name = summoner.getName();
        summonerID = summoner.getId();
        accountID = summoner.getAccountId();
        puuid = summoner.getPuuid();
        summonerLevel = summoner.getSummonerLevel();
        profileIconID = summoner.getProfileIconId();
    }
    public String getName() {
        return name;
    }

    public String getSummonerID() {
        return summonerID;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getPuuid() {
        return puuid;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public int getProfileIconID() {
        return profileIconID;
    }

    public Summoner getSummoner() {
        return summoner;
    }
}
