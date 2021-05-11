package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Repository.SkillsRepository;

import java.util.Optional;

@Service
public class SkillServices {
    final private SkillsRepository skillsRepository;

    @Autowired
    public SkillServices(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public void addSkillCategory(SkillsCategory skill){
        Optional<SkillsCategory> skillsCategory = skillsRepository.findBySkillName(skill.getName());
        if (skillsCategory.isPresent()){
            throw new IllegalStateException(skill.getName()+" is already registered as a skill category");
        }
        skillsRepository.save(skill);
    }

}
