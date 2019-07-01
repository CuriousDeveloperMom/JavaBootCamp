package com.company.U1M4SummativeSolankiPriti.Controller;

import com.company.U1M4SummativeSolankiPriti.Model.Answer;
import com.company.U1M4SummativeSolankiPriti.Model.Definition;
import com.company.U1M4SummativeSolankiPriti.Model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Controller {

    List<Quote> quoteList = new ArrayList<>();
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote randomQuote() {

        Quote q1 = new Quote("Abrahm Lincolm", "Prose is architecture, not interior decoration.");
        Quote q2 = new Quote("Priti", "It’s none of their business that you have to learn to write. Let them think you were born that way.");
        Quote q3 = new Quote("Cristopher", "I try to create sympathy for my characters, then turn the monsters loose.");
        Quote q4 = new Quote("Abhi", "First, find out what your hero wants, then just follow him!");
        Quote q5 = new Quote("Robert Graves", "I love deadlines. I like the whooshing sound they make as they fly by.");
        Quote q6 = new Quote("William Faulkner", "Words are a lens to focus one’s mind.");
        Quote q7 = new Quote("Henry Miller", "There’s no money in poetry, but then there’s no poetry in money either.");
        Quote q8 = new Quote("AA", "The work never matches the dream of perfection the artist has to start with.");
        Quote q9 = new Quote("AB", "Writing is its own reward.");
        Quote q10 = new Quote("AC", "Prose is architecture, not interior decoration.");
        quoteList.add(q1);
        quoteList.add(q2);
        quoteList.add(q3);
        quoteList.add(q4);
        quoteList.add(q5);
        quoteList.add(q6);
        quoteList.add(q7);
        quoteList.add(q8);
        quoteList.add(q9);
        quoteList.add(q10);
        Random random = new Random();
        int i = random.nextInt(quoteList.size());
        return quoteList.get(i);
    }

    List<Definition> definitionList = new ArrayList<>();
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition randomDefinition() {

        Definition d1 = new Definition("novel", "an extended fictional work in prose");
        Definition d2 = new Definition("reflect", "show an image of");
        Definition d3 = new Definition("convince", "make realize the truth or validity of something");
        Definition d4 = new Definition("convention", "a large formal assembly");
        Definition d5 = new Definition("cardinal", "one of a group of prominent bishops in the Sacred College");
        Definition d6 = new Definition("credible", "appearing to merit belief or acceptance");
        Definition d7 = new Definition("ascertain", "learn or discover with confidence");
        Definition d8 = new Definition("proceeding", "a sequence of steps by which legal judgments are invoked");
        Definition d9 = new Definition("extravagant", "recklessly wasteful");
        Definition d10 = new Definition("venerate", "regard with feelings of respect and reverence");

        definitionList.add(d1);
        definitionList.add(d2);
        definitionList.add(d3);
        definitionList.add(d4);
        definitionList.add(d5);
        definitionList.add(d6);
        definitionList.add(d7);
        definitionList.add(d8);
        definitionList.add(d9);
        definitionList.add(d10);
        Random random = new Random();
        int i = random.nextInt(definitionList.size());
        return definitionList.get(i);
    }

    List<Answer> answerList = new ArrayList<>();
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer randomAnswer(@RequestBody @Valid String str) {

        List<String> answers = new ArrayList<>();
        answers.add("It is certain.");
        answers.add("It is decidedly so.");
        answers.add("You may rely on it");
        answers.add("Yes - definitely!");
        answers.add("Without a doubt.");
        answers.add("Most likely.");

        Random random = new Random();
        int i = random.nextInt(answers.size());
        Answer a = new Answer(str,answers.get(i));
        return a;
    }

}


