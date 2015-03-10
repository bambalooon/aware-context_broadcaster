package com.aware.cdm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aware.cdm.processor.ContextPropertyProcessor;
import com.aware.cdm.processor.ContextUpdateBroadcaster;
import com.aware.cdm.record.ContextProperty;

/**
 * Created by Krzysztof Balon on 2015-02-22.
 */
public class ContextUpdateReceiver extends BroadcastReceiver {
    private final ContextPropertyProcessor contextPropertyProcessor;

    public ContextUpdateReceiver(ContextPropertyProcessor contextPropertyProcessor) {
        this.contextPropertyProcessor = contextPropertyProcessor;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ContextProperty contextProperty = intent.getParcelableExtra(ContextUpdateBroadcaster.CONTEXT_RECORD_EXTRA);
        contextPropertyProcessor.process(contextProperty);
    }
}
