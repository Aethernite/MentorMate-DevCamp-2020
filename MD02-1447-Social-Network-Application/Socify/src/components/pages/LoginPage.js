import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Bootstrap
import { Form, FormGroup, Button, Col, Row, Container, Alert, Spinner } from 'react-bootstrap';
//CSS
import '../../css/Forms.css';
//Formik
import { useFormik } from 'formik';
//Yup validation
import * as Yup from 'yup';
//Class names
import classNames from 'classnames';
//React Router Dom
import { Link } from 'react-router-dom';
import { login } from '../../store/slices/auth';
import { useSelector, useDispatch } from 'react-redux';



function LoginPage() {

    const error = useSelector(state => state.auth.error);
    const isLoading = useSelector(state => state.auth.isLoading);
    const dispatch = useDispatch();

    const validationSchema = Yup.object({
        username: Yup.string().required('Username is required'),
        password: Yup.string().required('Password is required')
    })


    const formik = useFormik({
        initialValues: {
            username: '',
            password: ''
        },

        onSubmit: (values) => {
            dispatch(login(values))
        },
        validationSchema: validationSchema,
    });

    return (
        <Container fluid style={{ paddingTop: '2rem' }}>
            <Row>
                <Col className="col-md-4 mx-auto">
                    <div className="myform">
                        <div className="logo mb-3">
                            <div className="col-md-12 text-center">
                                <h1>Socify</h1>
                                <h2>Login</h2>
                            </div>
                        </div>
                        {error && <Alert variant="danger">{error}</Alert>}
                        <Form onSubmit={formik.handleSubmit}>
                            <FormGroup>
                                <label className="form-label">Username</label>
                                <input type="text" name="username" className={'form-control ' + classNames(formik.touched.username && !formik.errors.username && 'is-valid', formik.touched.username && formik.errors.username && 'is-invalid')} id="username" placeholder="Enter Username" onBlur={formik.handleBlur} onChange={formik.handleChange} value={formik.values.username} />
                            </FormGroup>
                            <FormGroup>
                                <label className="form-label">Password</label>
                                <input type="password" name="password" id="password" className={'form-control ' + classNames(formik.touched.password && !formik.errors.password && 'is-valid', formik.touched.password && formik.errors.password && 'is-invalid')} placeholder="Enter Password" onBlur={formik.handleBlur} onChange={formik.handleChange} value={formik.values.password} />
                            </FormGroup>
                            <FormGroup>
                                <p className="text-center">By signing up you accept our <a href="#TermsOfUse">Terms Of Use</a></p>
                            </FormGroup>
                            <div className="col-md-12 text-center ">
                                <Button disabled={!formik.isValid} hidden={isLoading} type="submit" className="btn-block mybtn btn-dark tx-tfm">Login</Button>
                                <Spinner hidden={!isLoading} animation="border" role="status">
                                    <span className="sr-only">Loading...</span>
                                </Spinner>
                            </div>
                            <FormGroup>
                                <p className="text-center">Don't have account? <Link to="/signup" id="signup">Sign up here</Link></p>
                            </FormGroup>
                        </Form>
                    </div>
                </Col>
            </Row>
        </Container >
    );
}

export default LoginPage;