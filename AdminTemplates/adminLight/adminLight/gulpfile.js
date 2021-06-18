'use strict';

const gulp = require('gulp');
const sass = require('gulp-sass');

sass.compiler = require('node-sass');

gulp.task('default', watch);
gulp.task('sass', compile);

function compile() {
    return gulp
        .src('assets/scss/*.scss')
        .pipe(sass({ outputStyle: 'compressed' }).on('error', sass.logError))
        .pipe(gulp.dest('assets/css/min/'));
}

function watch() {
    gulp.watch('assets/scss/*.scss', compile);
}