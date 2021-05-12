package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<List<String>> listOfAllSKillsAndIds(){
        List<SkillsCategory> skillsCategories = skillsRepository.findAll();
        List<List<String>> skillList = new ArrayList<List<String>>();

        for(SkillsCategory skill: skillsCategories){
            List<String> skillAndId = new ArrayList<>();
            skillAndId.add(String.valueOf(skill.getId()));
            skillAndId.add(skill.getName());
            skillList.add(skillAndId);
        }
        return skillList;
    }

}
