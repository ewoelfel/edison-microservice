package de.otto.edison.jobs.status;

import de.otto.edison.jobs.definition.JobDefinition;
import de.otto.edison.status.domain.StatusDetail;
import de.otto.edison.status.indicator.StatusDetailIndicator;

import java.util.List;

import static java.util.Collections.singletonList;


public class JobStatusDetailIndicator implements StatusDetailIndicator {

    private final JobStatusCalculator jobStatusCalculator;
    private final JobDefinition jobDefinition;

    public JobStatusDetailIndicator(final JobDefinition jobDefinition,
                                    final JobStatusCalculator jobStatusCalculator) {
        this.jobDefinition = jobDefinition;
        this.jobStatusCalculator = jobStatusCalculator;
    }

    /**
     * Return the current StatusDetail state.
     *
     * @return StatusDetail
     */
    @Override
    public List<StatusDetail> statusDetails() {
        return singletonList(jobStatusCalculator.statusDetail(jobDefinition));
    }
}
