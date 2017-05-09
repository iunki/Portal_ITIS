package org.itis.portal.controller;

import org.itis.portal.entity.Reference;
import org.itis.portal.repository.AccountRepository;
import org.itis.portal.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by thefp on 03.05.2017.
 */
@Controller
public class ReferenceController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ReferenceRepository referenceRepository;

    @RequestMapping(value = "/references", method = RequestMethod.GET)
    @ResponseBody
    public List<Reference> getReferences(@RequestParam Boolean withOutIssued) {
        return withOutIssued ? referenceRepository.findAllWithOutIssued():referenceRepository.findAll();
    }

    @RequestMapping(value = "/referencecreate", method = RequestMethod.GET)
    @ResponseBody
    public void createReference(Principal principal, @RequestParam Integer count) {
        Reference reference = new Reference();
        reference.setCount(count);
        reference.setStudent(accountRepository.findOneByEmail(principal.getName()).getStudent());
        reference.setDate(new Date());
        reference.setIssued(false);
        referenceRepository.save(reference);
    }

    @RequestMapping(value = "/referencesetissued", method = RequestMethod.GET)
    @ResponseBody
    public void setIssuedReference(@RequestParam Integer id) {
        referenceRepository.updateStatus(id);
    }
}
