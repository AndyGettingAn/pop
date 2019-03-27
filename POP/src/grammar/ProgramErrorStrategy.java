package grammar;

import org.antlr.v4.runtime.*;

public class ProgramErrorStrategy extends DefaultErrorStrategy
{
    private boolean errorOccurred;

    public ProgramErrorStrategy() {
        errorOccurred = false;
    }

    public boolean codeHasSyntaxErrors() {
        return errorOccurred;
    }
    @Override
    public void recover(Parser recognizer, RecognitionException e){
        errorOccurred = true;
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        errorOccurred = true;
        return super.recoverInline(recognizer);
    }

    @Override
    public void sync(Parser recognizer){}
}
