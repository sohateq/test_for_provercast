package com.akameko.testforprovercast.dagger;

import com.akameko.testforprovercast.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    Repository provideRepository() {
        return new Repository();
    }
}
