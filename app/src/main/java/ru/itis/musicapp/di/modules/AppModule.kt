package ru.itis.musicapp.di.modules

import dagger.Module

@Module(includes = [
    NetModule::class,
    RepoModule::class
])
class AppModule {

}
