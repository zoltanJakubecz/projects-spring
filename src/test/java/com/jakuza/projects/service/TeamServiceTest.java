package  com.jakuza.projects.service;

import static org.mockito.Mockito.verify;

import com.jakuza.projects.model.Team;
import com.jakuza.projects.repository.StudentRepository;
import com.jakuza.projects.repository.TeamRepository;

import org.h2.value.ValueTimestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.assertj.core.api.Assertions.assertThat;
/**
 * TeamServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;
    @Mock
    private StudentRepository studentRepository;
    
    private TeamService teamService;

    
    @BeforeEach
    void setUp() {
        teamService = new TeamService(teamRepository, studentRepository);
    }


    @Test
    void canGetAllTeams() {
        teamService.getAll();
        verify(teamRepository).findAll();
    }



    @Test
    void cadAddNewTeam(){
        Team team = new Team();
        team.setName("Kings");
        team.setTeamAvatarUrl("http://www.avatar.hu/kings");
        teamService.add(team);
            
        ArgumentCaptor<Team> teamArgumentCaptor =
                ArgumentCaptor.forClass(Team.class);

        verify(teamRepository)
                .save(teamArgumentCaptor.capture());

        Team capturedStudent = teamArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(team);
    }

    
}
