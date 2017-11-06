package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.bdd.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Ricardo on 11/4/2017.
 */
public abstract class SyntacticRule<T>{

  protected final Parser parser;
  protected final SyntacticRule parent;
  protected final List<SyntacticRule> allRules;

  public SyntacticRule(Parser parser, SyntacticRule parent) {
    this.parser = parser;
    this.parent = parent;

    if(parent == null)
      allRules = new ArrayList<>();
    else
      allRules = root().allRules;

    allRules.add(this);
  }

  public SyntacticRule<T> root() {
    SyntacticRule<T> cur = this;

    while(cur.parent != null)
      cur = cur.parent;

    return cur;
  }

  public abstract boolean lookAhead();
  public abstract T match();


  /**
   * Equivalent to (RULE)+
   * @param consumer  Receives the matched element
   */
  public List<T> matchOneOrMany() {
    List<T> found = new ArrayList<>();
    do
      found.add(this.match());
    while(lookAhead());

    return found;
  }

  public boolean matchesAnyRule() {

    if(parser.isEOF())
      return true;

    for(SyntacticRule rule: allRules)
      if(rule.lookAhead())
        return true;

    return false;
  }

  public List<T> matchZeroOrMore() {
    List<T> found = new ArrayList<>();

    while(lookAhead())
      found.add(this.match());

    return found;
  }
}
