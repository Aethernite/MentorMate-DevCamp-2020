import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Bootstrap
import { Form, FormGroup, Button, Col, Row, Container, Spinner, Alert } from 'react-bootstrap';
//CSS
import '../../css/Forms.css';
//Yup validation
import * as Yup from 'yup';
//Formik
import { useFormik } from 'formik';
//Class names
import classNames from 'classnames';
//React-Router-Dom
import { Link } from 'react-router-dom';
//Authentication hook
import { useSelector, useDispatch } from 'react-redux';
import { register, clearErrors } from '../../store/slices/auth'

function RegisterPage() {

    const validationSchema = Yup.object({
        firstname: Yup.string()
            .matches(/^[A-Z][a-z]+$/, 'Please enter valid name')
            .min(2, 'The name must be minimum of 2 characters')
            .max(40, 'The name cannot exceed 40 characters')
            .required('This field is required'),
        lastname: Yup.string()
            .matches(/^[A-Z][a-z]+$/, 'Please enter valid name')
            .min(2, 'The name must be minimum of 2 characters')
            .max(40, 'The name cannot exceed 40 characters')
            .required('This field is required'),

        username: Yup.string()
            .matches(/^[\w]+$/)
            .min(8, 'The  username must be minimum of 8 characters')
            .max(40, 'The usernamename cannot exceed 40 characters')
            .required('This field is required'),

        password: Yup.string()
            .min(6, 'The password must be minimum of 6 characters')
            .required('This field is required')
    })


    const formik = useFormik({
        initialValues: {
            firstname: '',
            lastname: '',
            username: '',
            password: ''
        },
        onSubmit: async (values) => {
            dispatch(register(values))
        },
        validationSchema: validationSchema,
    });

    const error = useSelector(state => state.auth.error);
    const dispatch = useDispatch();

    React.useEffect(() => {
        dispatch(clearErrors());
    }, [dispatch]);

    return (
        <Container fluid style={{ paddingTop: '2rem' }}>
            <Row>
                <Col className="col-md-4 mx-auto">
                    <div className="myform">
                        <div className="logo mb-3">
                            <div className="col-md-12 text-center">
                                <h1>Socify</h1>
                                <h2>Signup</h2>
                            </div>
                        </div>
                        {error && <Alert variant="danger">{error}</Alert>}
                        <Form onSubmit={formik.handleSubmit}>
                            <FormGroup>
                                <label className="form-label">First Name</label>
                                <input type="text" name="firstname" className={'form-control ' + classNames(formik.touched.firstname && !formik.errors.firstname && 'is-valid', formik.touched.firstname && formik.errors.firstname && 'is-invalid')} id="firstname" placeholder="Enter First Name" onBlur={formik.handleBlur} onChange={formik.handleChange} value={formik.values.firstname} />
                            </FormGroup>
                            {formik.errors.firstname && formik.touched.firstname ? (
                                <Alert variant="danger">{formik.errors.firstname}</Alert>
                            ) : null}
                            <FormGroup>
                                <label className="form-label">Last Name</label>
                                <input type="text" name="lastname" className={'form-control ' + classNames(formik.touched.lastname && !formik.errors.lastname && 'is-valid', formik.touched.lastname && formik.errors.lastname && 'is-invalid')} id="lastname" placeholder="Enter Last Name" onBlur={formik.handleBlur} onChange={formik.handleChange} value={formik.values.lastname} />
                            </FormGroup>
                            {formik.errors.lastname && formik.touched.lastname ? (
                                <Alert variant="danger">{formik.errors.lastname}</Alert>
                            ) : null}
                            <FormGroup>
                                <label className="form-label">Username</label>
                                <input type="text" name="username" className={'form-control ' + classNames(formik.touched.username && !formik.errors.username && 'is-valid', formik.touched.username && formik.errors.username && 'is-invalid')} id="username" placeholder="Enter Username" onBlur={formik.handleBlur} onChange={formik.handleChange} value={formik.values.username} />
                            </FormGroup>
                            {formik.errors.username && formik.touched.username ? (
                                <Alert variant="danger">{formik.errors.username}</Alert>
                            ) : null}
                            <FormGroup>
                                <label className="form-label">Password</label>
                                <input type="password" name="password" id="password" className={'form-control ' + classNames(formik.touched.password && !formik.errors.password && 'is-valid', formik.touched.password && formik.errors.password && 'is-invalid')} placeholder="Enter Password" onBlur={formik.handleBlur} onChange={formik.handleChange} value={formik.values.password} />
                            </FormGroup>
                            {formik.errors.password && formik.touched.password ? (
                                <Alert variant="danger">{formik.errors.password}</Alert>
                            ) : null}
                            <div className="col-md-12 text-center mb-3">
                                <Button disabled={!formik.isValid} hidden={formik.isSubmitting} type="submit" className="btn-block mybtn btn-dark tx-tfm">Get Started For Free</Button>
                                <Spinner hidden={!formik.isSubmitting} animation="border" role="status">
                                    <span className="sr-only">Loading...</span>
                                </Spinner>
                            </div>
                            <div className="col-md-12 ">
                                <FormGroup>
                                    <p className="text-center"><Link to="/login" id="signin">Already have an account?</Link></p>
                                </FormGroup>
                            </div>
                        </Form>

                    </div>
                </Col>
            </Row>
        </Container >
    );
}

export default RegisterPage;