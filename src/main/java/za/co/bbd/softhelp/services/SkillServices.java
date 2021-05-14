package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.CommandLineRunner.SkillsAndStatus;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Repository.SkillsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SkillServices {
    final private SkillsRepository skillsRepository;

    @Autowired
    public SkillServices(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public List<SkillsCategory> listOfAllSKillsAndIds(){
        return skillsRepository.findAll();
    }

    public String addSkillToClient(Client client, Long skillId){

        SkillsCategory skill = SkillsAndStatus.getSkillsCategory().get(skillId.intValue()-1);
        skill.setUser(List.of(client));
        client.addSkillCategory(skill);

        skillsRepository.saveAll(List.of(skill));

        return "Skill has been added to user.";
    }

    public SkillsCategory getSkillObjectById(Long id){
        SkillsCategory skill = skillsRepository.findById(id).get();

        if(skill.equals(null)){
            throw new IllegalStateException("Skill id does not exist");
        }
        return skill;
    }
}
