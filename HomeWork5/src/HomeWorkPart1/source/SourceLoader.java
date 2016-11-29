package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider sp: sourceProviders){
            if(sp.isAllowed(pathToSource)){
                return sp.load(pathToSource);
            }
        }
        throw new SourceLoadingException();
    }
}