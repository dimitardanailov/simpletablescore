package score.tennis.table.tabletennisscore;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ScoreActivity extends Activity implements View.OnClickListener {

    private Button homeTeam;
    private Button awayTeam;
    private Button resetScore;

    private int homeTeamScore = 0;
    private int awayTeamScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        homeTeam = (Button) findViewById(R.id.home_team_points);
        setHomeScore();
        homeTeam.setOnClickListener(this);

        awayTeam = (Button) findViewById(R.id.away_team_points);
        setAwayScore();
        awayTeam.setOnClickListener(this);

        resetScore = (Button) findViewById(R.id.reset_button);
        resetScore.setOnClickListener(this);
    }

    protected void setHomeScore() {
        homeTeam.setText(String.valueOf(homeTeamScore));
    }

    protected void setAwayScore() {
        awayTeam.setText(String.valueOf(awayTeamScore));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.reset_button:
                homeTeamScore = 0;
                awayTeamScore = 0;
                setHomeScore();
                setAwayScore();
                break;
            case R.id.home_team_points:
                homeTeamScore++;
                setHomeScore();
                break;
            case R.id.away_team_points:
                awayTeamScore++;
                setAwayScore();
        }
    }
}
