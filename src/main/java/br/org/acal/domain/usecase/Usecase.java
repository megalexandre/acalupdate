package br.org.acal.domain.usecase;

public interface Usecase<In, Out> {
    Out execute(In in);
}
