package top.jonakls.bomberman.api.model.user.stats;

public class UserStats {

    private int kills;
    private int deaths;
    private int games;
    private int wins;
    private int loses;
    private int bombs;
    private int powerUps;
    private int powerDowns;
    private int speedUps;

    public UserStats(
            int kills, int deaths, int games,
            int wins, int loses, int bombs,
            int powerUps, int powerDowns, int speedUps
    ) {
        this.kills = kills;
        this.deaths = deaths;
        this.games = games;
        this.wins = wins;
        this.loses = loses;
        this.bombs = bombs;
        this.powerUps = powerUps;
        this.powerDowns = powerDowns;
        this.speedUps = speedUps;
    }

    public static UserStats empty() {
        return new UserStats(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public static UserStats from(
            int kills, int deaths, int games,
            int wins, int loses, int bombs,
            int powerUps, int powerDowns, int speedUps
    ) {
        return new UserStats(
                kills, deaths, games,
                wins, loses, bombs,
                powerUps, powerDowns, speedUps
        );
    }

    public int kills() {
        return kills;
    }

    public void kills(int kills) {
        this.kills = kills;
    }

    public void addKill() {
        this.kills++;
    }

    public int deaths() {
        return deaths;
    }

    public void deaths(int deaths) {
        this.deaths = deaths;
    }

    public void addDeath() {
        this.deaths++;
    }

    public int games() {
        return games;
    }

    public void games(int games) {
        this.games = games;
    }

    public void addGame() {
        this.games++;
    }

    public int wins() {
        return wins;
    }

    public void wins(int wins) {
        this.wins = wins;
    }

    public void addWin() {
        this.wins++;
    }

    public int loses() {
        return loses;
    }

    public void loses(int loses) {
        this.loses = loses;
    }

    public void addLose() {
        this.loses++;
    }

    public int bombs() {
        return bombs;
    }

    public void bombs(int bombs) {
        this.bombs = bombs;
    }

    public void addBomb() {
        this.bombs++;
    }

    public int powerUps() {
        return powerUps;
    }

    public void powerUps(int powerUps) {
        this.powerUps = powerUps;
    }

    public void addPowerUp() {
        this.powerUps++;
    }

    public int powerDowns() {
        return powerDowns;
    }

    public void powerDowns(int powerDowns) {
        this.powerDowns = powerDowns;
    }

    public void addPowerDown() {
        this.powerDowns++;
    }

    public int speedUps() {
        return speedUps;
    }

    public void speedUps(int speedUps) {
        this.speedUps = speedUps;
    }

    public void addSpeedUp() {
        this.speedUps++;
    }
}
