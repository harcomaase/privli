package de.mh.privli.boundary;

import de.mh.privli.entity.LinkEntry;
import de.mh.privli.entity.repository.LinkEntryRepository;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = LinkResolver.PATH)
public class LinkResolver {

    public static final String PATH = "/a";

    @Autowired
    private LinkEntryRepository linkEntryRepository;

    private static final String PAGE_TEMPLATE = "<html><head><title>Link to: {{description}}</title></head><body style=\"font-family:monospace;font-size:1.25rem;\"><div style=\"margin:auto;text-align:center;padding:2rem 0 0 0;\"><span style=\"background-color:lightgrey; color:blue;\">{{linkAlias}}</span>{{fullDescription}}<br/><br/>full link (click to follow):<br/><a href=\"{{fullLink}}\">{{fullLink}}</a></div></body></html>";
    //
    private static final Logger LOGGER = Logger.getLogger(LinkResolver.class.getName());

    @RequestMapping(path = "/{linkAlias}", method = RequestMethod.GET)
    public String resolve(@PathVariable("linkAlias") String linkAlias) {
        LOGGER.info("request for: " + linkAlias);

        LinkEntry linkEntry = linkEntryRepository.findByLinkAlias(linkAlias);
        if (linkEntry == null) {
            LOGGER.info("linkAlias '" + linkAlias + "' not found");
            linkEntry = new LinkEntry();
            linkEntry.setDescription("link not found!");
            linkEntry.setLinkAlias(linkAlias);
            linkEntry.setFullLink("#");
        }

        return PAGE_TEMPLATE
                .replace("{{description}}", linkEntry.getDescription())
                .replace("{{fullDescription}}", notEmpty(linkEntry.getDescription()) ? "<br/>description: " + linkEntry.getDescription() : "")
                .replace("{{linkAlias}}", linkEntry.getLinkAlias())
                .replace("{{fullLink}}", linkEntry.getFullLink());
    }

    private boolean notEmpty(String string) {
        return string != null && !string.isBlank();
    }
}
