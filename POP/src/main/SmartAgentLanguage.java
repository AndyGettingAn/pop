package main;

import declaration.Block;
import grammar.ProgramErrorStrategy;
import grammar.programLexer;
import grammar.programParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

public class SmartAgentLanguage {
    private Interpreter runtimeMachine;
    private grammar.Compiler myCompiler;
    private Block mainBlock;

    public SmartAgentLanguage() {
    }

    public void run() {
        new Editor(this);

    }

    public void executeCode(InputStream code) {
        try {
            ProgramErrorStrategy pes = new ProgramErrorStrategy();
            programLexer myLexer = new programLexer(CharStreams.fromStream(code));
            CommonTokenStream tokens = new CommonTokenStream(myLexer);
            programParser myParser = new programParser(tokens);
            myParser.setErrorHandler(pes);

            ParseTree tree = myParser.prule();

            if (!pes.codeHasSyntaxErrors()) {
                ParseTreeWalker myWalker = new ParseTreeWalker();
                myCompiler = new grammar.Compiler();
                myWalker.walk(myCompiler, tree);
                Interpreter.getRuntime().execute(myCompiler.getCurrentBlock());
            }
            else System.out.println("FIX syntax errors and recompile.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        myCompiler = new Compiler(code);
        mainBlock = myCompiler.program();
        if (mainBlock != null) Interpreter.getRuntime().execute(mainBlock);
        else System.out.println("Errors in source file. Cannot execute program.");
        */
    }

    static public void main(String [] args) {
        SmartAgentLanguage l = new SmartAgentLanguage();
        l.run();
    }
}
