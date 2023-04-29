package sk.fzdp.ciphers.swappairs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SwappairsController {

	/** Flag for waiting when enabled */
    private boolean timeout = false;
    /** Flag for throwing a 503 when enabled */
    private boolean misbehave = false;
    
	@Autowired
	private SwappairsService swappairsService;

	@RequestMapping(path = "/swappairs/encode/{text}", method = RequestMethod.GET)
	public String encodeSwappairs(@PathVariable String text) {
		if (timeout) {
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
        }
        if (misbehave) {
        	throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Service misbehaving...");
        }
		return swappairsService.encode(text);
	}
	
	@RequestMapping(path = "/swappairs/decode/{text}", method = RequestMethod.GET)
	public String decodeSwappairs(@PathVariable String text) {

		return swappairsService.decode(text);
	}

	@RequestMapping(path = "/swappairs/timeout", method = RequestMethod.GET)
    public String flagTimeout() {
        this.timeout = true;
        return "Ok";
    }

	@RequestMapping(path = "/swappairs/timein", method = RequestMethod.GET)
    public String flagTimein() {
        this.timeout = false;
        return "Ok";
    }

	@RequestMapping(path = "/swappairs/misbehave", method = RequestMethod.GET)
    public String flagMisbehave() {
        this.misbehave = true;
        return "Ok";
    }

	@RequestMapping(path = "/swappairs/behave", method = RequestMethod.GET)
    public String flagBehave() {
        this.misbehave = false;
        return "Ok";
    }
}
