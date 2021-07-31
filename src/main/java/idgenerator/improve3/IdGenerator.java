package idgenerator.improve3;

import idgenerator.improve3.exception.IdGenerationFailureException;

public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
